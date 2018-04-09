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
        ,data: "/resource/spider/vod/search"
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
            ,{field: 'filmName', width:'20%',title: '电影名称', }
            ,{field: 'filmType', title: '电影类型' }
            ,{field: 'titleImg', title: '标题图片'}
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

        var filmName=$("#filmName").val();
        //执行重载
        table.reload('filmId', {
            where: {
                filmName:filmName
            }
        });
    });




});

