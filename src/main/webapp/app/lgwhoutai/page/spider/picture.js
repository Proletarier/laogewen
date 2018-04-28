layui.use(['form','laydate','table','laypage','jquery','layer','util'], function(){
    var laydate=layui.laydate
        ,table = layui.table
        ,form=layui.form
        ,layer = parent.layer === undefined ? layui.layer : parent.layer
        ,laypage = layui.laypage
        ,util = layui.util
    $ = layui.jquery;

    table.render({
        skin: 'line' //行边框风格
        ,elem: '#picture'
        ,id: 'pictureId'
        ,url: '/resource/spider/pic/search'
        ,page: true
        ,request: {
            pageName: 'pageNum' //页码的参数名称，默认：page
            ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
        }
        ,response:{
            statusName: 'status' //数据状态的字段名称，默认：code
            ,statusCode: 1 //成功的状态码，默认：0
            ,msgName: 'msg' //状态信息的字段名称，默认：msg
            ,countName: 'total' //数据总数的字段名称，默认：count
            ,dataName: 'data' //数据列表的字段名称，默认：data
        }
        ,cols: [[
            {type:'checkbox'}
            ,{field: 'name', width:'20.5%',title: '图片名称', }
            ,{field: 'typeCode', width:'15%',title: '图片类型' }
            ,{field: 'url', width:'10%',title: 'url' }
            ,{field: 'md5', width:'14%',title:'md5' }
            ,{fixed: 'right' ,width:'20%', toolbar: '#barDemo'}
        ]]
    });

    form.render();


    //查詢
    $('.search_btn').on('click', function(){

        var name=$("#picName").val();
        //执行重载
        table.reload('pictureId', {
            where: {
                name:name
            }
        });
    });



    //监听工具条
    table.on('tool(pic)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.pictureId + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                $.ajax({
                    type:"DELETE",
                    url:"/resource/spider/pic",
                    data: JSON.stringify({"id":data.pictureId}),
                    contentType:"application/json",
                    dataType:"json",
                    success:function (result) {
                        if(result.status==1){
                            layer.msg("删除成功");
                            obj.del();
                            layer.close(index);
                        }
                    }});
            });
        } else if(obj.event === 'edit'){
            $("#pictureId").attr("value",data.pictureId);
            var index = layui.layer.open({
                anim: 1,
                title : "修改图片",
                id:data.filmId,
                type : 2,
                content : "PictureUpdate.html?",
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回图片列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            layui.layer.full(index);
        }
    });

    var active = {
        startSpider: function(){
            //开始爬虫
            layer.open({
                type: 2
                ,title: '爬取数据'
                ,closeBtn: false
                ,fixed: true
                ,anim: 2
                ,shade: 0.8
                ,area: ['500px', '400px']
                ,skin: 'layui-layer-molv'
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,btn: ['开始爬取', '返回']
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: ['page/spider/spiderStart.html?api=/resource/PictureRegex/search','no']
                ,success:function (layero,index) {
                }
                ,yes: function(index, layero){

                    var regexId = $("select", layero.find("iframe")[0].contentWindow.document).select().val();
                    var seeds=$(".seed", layero.find("iframe")[0].contentWindow.document).val();
                    var validate=$(".validate", layero.find("iframe")[0].contentWindow.document).val();
                    var size=$(".size", layero.find("iframe")[0].contentWindow.document).val();

                    $.ajax(
                        {
                            type:"GET",
                            url:"/resource/spider/getSpider?key=PictureKey",
                            contentType:"application/json",
                            dataType:"json",
                            data: {seeds:seeds,validate:validate,size:size},
                            success: function (result) {
                                parent.location.reload();
                            }
                        }
                    );

                    layer.close(index);
                }
                ,btn2: function(index, layero){
                    layer.close(index);
                }
            });
        },
        stopSPider:function () {
            layer.open({
                type: 2
                ,title: '正在获取数据'
                ,closeBtn: false
                ,fixed: true
                ,anim: 2
                ,shade: 0.8
                ,area: ['500px', '400px']
                ,skin: 'layui-layer-molv'
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,btn: ['结束任务', '返回']
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: ['page/spider/spiderStop.html','no']
                ,yes: function(index, layero){

                }
                ,btn2: function(index, layero){
                    layer.close(index);
                }
            });
        }};



    $('.newsAdd_btn').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });


    layer.ready(function(){
        $.get("/resource/spider/isWorking",{key:"PictureKey"},function (data,status,xhr) {
            if(status=='success'){
                if(data==false){
                    $(".newsAdd_btn").attr("data-method","startSpider");
                    $(".newsAdd_btn b").innerHTML="开始爬取";
                }else{
                    $(".newsAdd_btn").attr("data-method","stopSPider");
                    $(".newsAdd_btn").find("b")[0].innerHTML="正在获取";
                }
            }
        })

    });

});

