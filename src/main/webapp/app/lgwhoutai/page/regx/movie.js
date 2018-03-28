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
        ,id: 'filmRegexId'
        ,height: 500
        ,url: '/resource/FilmRegex/search'
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
            ,{field: 'titleRegex', width:'19.5%',title: '标题', }
            ,{field: 'typeRegex', width:'20%',title: '类型' }
            ,{field: 'description', width:'20%',title: '描述' }
            ,{field: 'creationDate', width:'15%',title: '创建时间',templet: '<div>{{layui.util.toDateString(d.createDate,"yyyy-MM-dd") }}</div>'}
            ,{fixed: 'right' ,width:'20%', toolbar: '#barDemo'}
        ]]
    });


    //日期范围
    laydate.render({
        elem: '#createDate'
        ,range: '~'
    });

    //添加电影正则
    $(window).one("resize",function(){

        $(".newsAdd_btn").click(function(){
            var index = layui.layer.open({
                title : "添加正则",
                type : 2,
                content : "movieRegxAdd.html",
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回正则列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            layui.layer.full(index);
        })
    }).resize();


    //监听工具条
    table.on('tool(vod)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.filmRegexId + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                $.ajax({
                    type:"DELETE",
                    url:"/resource/FilmRegex",
                    data: JSON.stringify({"id":data.filmRegexId}),
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
            $("#filmRegexId").attr("value",data.filmRegexId);
            var index = layui.layer.open({
                anim: 1,
                title : "修改正则",
                id:data.filmId,
                type : 2,
                content : "movieRegxUpdate.html?",
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回电影正则列表', '.layui-layer-setwin .layui-layer-close', {
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
        var description=$("#description").val();
        var startDate;
        var endDate;
        if(date.trim()!=""){
            startDate=date.split('~')[0].trim('+');
            endDate=date.split('~')[1].trim('+');
        }

        //执行重载
        table.reload('filmRegexId', {
            where: {
                description:description,
                startDate:startDate,
                endDate:endDate
            }
        });
    });

});

