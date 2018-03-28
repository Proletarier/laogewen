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
        ,elem: '#novel'
        ,id: 'novelId'
        ,height: 500
        ,url: '/resource/novel/search'
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
            ,{field: 'title', width:'30.5%',title: '小说名称', }
            ,{field: 'typeCodeMeaning', width:'15%',title: '小说类型' }
            ,{field: 'createDate', width:'15%',title: '创建时间',templet: '<div>{{layui.util.toDateString(d.createDate,"yyyy-MM-dd") }}</div>'}
            ,{field: 'enableFlag', width:'14%',title:'是否启用', templet: '#checkboxTpl' ,align:'center' }
            ,{fixed: 'right' ,width:'20%', toolbar: '#barDemo'}
        ]]
    });


    //日期范围
    laydate.render({
        elem: '#createDate'
        ,range: '~'
    });

    //添加小说
    $(window).one("resize",function(){

        $(".newsAdd_btn").click(function(){
            var index = layui.layer.open({
                title : "添加小说",
                type : 2,
                content : "novelAdd.html",
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回小说列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            layui.layer.full(index);
        })
    }).resize();

    //启用禁用
    form.on('checkbox(lockDemo)', function(obj){
        var enableFlag;
        if(obj.elem.checked==true){
            enableFlag='Y';
        }else {
            enableFlag='N';
        }
        $.ajax({
            type:"PUT",
            url:"/resource/novel/update/enableFlag",
            data: JSON.stringify({"id":this.value,"enableFlag":enableFlag}),
            contentType:"application/json",
            dataType:"json",
            success:function (result) {
                if(result.status==1){
                    if (obj.elem.checked==true){
                        layer.msg("启用成功");
                    }else {
                        layer.msg("禁用成功");
                    }
                }else {
                    layer.msg(result.msg);
                }
            }});

    });

    //监听工具条
    table.on('tool(novel)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.novelId + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                $.ajax({
                    type:"DELETE",
                    url:"/resource/novel",
                    data: JSON.stringify({"id":data.novelId}),
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
                        layui.layer.tips('点击此处返回小说列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            layui.layer.full(index);
        }
    });


    //查詢
    $('.search_btn').on('click', function(){

        var date=$("#createDate").val();
        var title=$("#title").val();
        var type=$("#novelType option:selected").val();
        var startDate;
        var endDate;
        if(date.trim()!=""){
            startDate=date.split('~')[0].trim('+');
            endDate=date.split('~')[1].trim('+');
        }
        //执行重载
        table.reload('novelId', {
            where: {
                title:title,
                type:type,
                startDate:startDate,
                endDate:endDate
            }
        });
    });

});

