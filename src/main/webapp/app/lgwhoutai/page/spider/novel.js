layui.use(['form','laydate','table','laypage','jquery','layer'], function(){
    var laydate=layui.laydate
        ,table = layui.table
        ,form=layui.form
        ,layer = parent.layer === undefined ? layui.layer : parent.layer
        ,laypage = layui.laypage
    $ = layui.jquery;

    table.render({
        skin: 'line' //行边框风格
        ,elem: '#novel'
        ,height: 500
        ,data: arr
        ,page: true
        ,response:{
            statusName: 'code' //数据状态的字段名称，默认：code
            ,statusCode: 200 //成功的状态码，默认：0
            ,msgName: 'msg' //状态信息的字段名称，默认：msg
            ,countName: 'count' //数据总数的字段名称，默认：count
            ,dataName: 'data' //数据列表的字段名称，默认：data
        }
        ,cols: [[
            {type:'checkbox'}
            ,{field: 'title', width:'30.5%',title: '小说名称', }
            ,{field: 'typeCodeMeaning', width:'15%',title: '小说类型' }
            ,{field: 'url', title: 'URL'}
            ,{field: 'md5', title: 'MD5'}
            ,{fixed: 'right' ,width:'20%', toolbar: '#barDemo'}
        ]]
    });

    form.render();

    //日期范围
    laydate.render({
        elem: '#createDate'
        ,range: true
    });


    //查詢
    $('.search_btn').on('click', function(){

        var title=$("#title").val();
        //执行重载
        table.reload('novelId', {
            where: {
                title:title
            }
        });
    });


});
