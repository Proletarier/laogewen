layui.use(['form','laydate','table','laypage','jquery','layer'], function(){
    var laydate=layui.laydate
        ,table = layui.table
        ,form=layui.form
        ,layer = parent.layer === undefined ? layui.layer : parent.layer
        ,laypage = layui.laypage
    $ = layui.jquery;

    table.render({
        skin: 'line' //行边框风格
        ,elem: '#movie'
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
            ,{field: 'username',width:'25%' , title: '图片名称'}
            ,{field: 'city', title: '图片类型' }
            ,{field: 'sign', title: '图片地址'}
            ,{field: 'sign', title: '文件地址'}
            ,{field: 'url', title: 'URL'}
            ,{field: 'md5', title: 'MD5'}
            ,{fixed: 'right', align:'center', toolbar: '#barDemo'}
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

        var name=$(".search_input").val();
        //执行重载
        table.reload('pictureId', {
            where: {
                name:name
            }
        });
    });

});
