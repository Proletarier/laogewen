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
        ,height: 500
        ,data: '/resource/film/search'
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
            ,{field: 'username',width:'25%' , title: '图片名称'}
            ,{field: 'city', title: '图片类型' }
            ,{field: 'sign', title: '图片地址'}
            ,{field: 'sign', title: '文件地址'}
            ,{field: 'classify', title: '创建时间'}
            ,{field: 'enableFlag', width:'14%',title:'是否启用', templet: '#checkboxTpl' ,align:'center' }
            ,{fixed: 'right', align:'center', toolbar: '#barDemo'}
        ]]
    });

    form.render();

    //日期范围
    laydate.render({
        elem: '#createDate'
        ,range: true
    });

    //添加图片
    $(window).one("resize",function(){
        $(".newsAdd_btn").click(function(){
            var index = layui.layer.open({
                title : "添加图片",
                type : 2,
                content : "pictureAdd.html",
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回图片列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            layui.layer.full(index);
        })
    }).resize();

});