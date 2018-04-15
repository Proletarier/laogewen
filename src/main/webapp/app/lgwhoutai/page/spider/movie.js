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
        ,elem: '#movie'
        ,id: 'filmId'
        ,height: 500
        ,url: '/resource/spider/vod/search'
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
            ,{field: 'filmName', width:'20.5%',title: '电影名称', }
            ,{field: 'filmType', width:'15%',title: '电影类型' }
            ,{field: 'titleImg', width:'15%',title: '标题图片' }
            ,{field: 'url', width:'10%',title: 'url' }
            ,{field: 'md5', width:'14%',title:'md5' }
            ,{fixed: 'right' ,width:'20%', toolbar: '#barDemo'}
        ]]
    });

    form.render();


    //查詢
    $('.search_btn').on('click', function(){

        var filmName=$("#filmName").val();
        //执行重载
        table.reload('filmId', {
            where: {
                filmName:filmName
            }
        });
    });


    //监听工具条
    table.on('tool(vod)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.filmId + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                $.ajax({
                    type:"DELETE",
                    url:"/resource/spider/vod",
                    data: JSON.stringify({"id":data.filmId}),
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
            $("#filmId").attr("value",data.filmId);
            var index = layui.layer.open({
                anim: 1,
                title : "修改电影",
                id:data.filmId,
                type : 2,
                content : "movieUpdate.html?",
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回电影列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            layui.layer.full(index);
        }
    });

    var active = {
    notice: function(){
        //示范一个公告层
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
            ,content: ['page/spider/spiderStart.html','no']
            ,yes: function(index, layero){
                alert(layero.content);
             //   layer.close(index); //如果设定了yes回调，需进行手工关闭
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




});

