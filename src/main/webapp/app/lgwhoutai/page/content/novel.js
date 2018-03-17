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
        ,data: '/resource/novel/search'
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
            ,{field: 'title', title: '小说名称', }
            ,{field: 'typeCodeMeaning', title: '小说类型' }
            ,{field: 'sign', title: '文章数量'}
            ,{field: 'createDate', width:'15%',title: '创建时间',templet: '<div>{{layui.util.toDateString(d.createDate,"yyyy-MM-dd") }}</div>'}
            ,{field: 'wealth', title: '点击数量',  sort: true}
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

});