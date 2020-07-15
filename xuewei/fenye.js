var pageData={};
            pageData.page=JSON.parse(data).data.page;
            pageData.page_count=Math.ceil(JSON.parse(data).data.count/limit);
            pageData.sum_count=JSON.parse(data).data.count;
 
            var html2=ejs.render(tem2,{data:pageData});
            document.getElementById("temp2-container").innerHTML = html2;
 
            clickPageNum();
            beforePage();
            afterPage();
            jumpInputPage();
//以上部分写在拉数据getPageData()的方法中的拉取到数据成功后的地方。
 
 
 
//点击1234页数
function clickPageNum() {
    $('#temp2-container').find('.jumpPage').click(function () {
        var click_num=this.innerHTML;
        var now_page=document.getElementById('before_page').dataset.nowpage;
        if(click_num!=now_page){
            // var now_page=document.getElementById('before_page').dataset.nowpage;
            getPageData(click_num);//拉取数据的方法
        }
    });
}
//点击上一页
function beforePage() {
    $('#before_page').click(function () {
        if(document.getElementById('after_page').dataset.maxpage!=0){
            var now_page=this.dataset.nowpage;
            if(now_page-1>0){
                getPageData(now_page-1);//拉取数据的方法
            }
            else {
                $.Huimodalalert('已经是第一页！',1500);
            }
        }
 
    });
}
function afterPage() {
    $('#after_page').click(function () {
        if(this.dataset.maxpage!=0){
            var now_page=this.dataset.nowpage;
            if(Number(now_page)>=Number(this.dataset.maxpage)){
                $.Huimodalalert('已经是最后一页！',1500);
            }
            else {
                getPageData(Number(now_page)+1);//拉取数据的方法
            }
        }
    });
}
//跳转至第几页
function jumpInputPage() {
    $('#page-jump-sure-button').click(function () {
        var input_num=$('#jump-page-input').val();
        console.log(input_num);
        var next_page_id=document.getElementById('after_page');
        var now_page=next_page_id.dataset.nowpage;
        var max_page=next_page_id.dataset.maxpage;
        // console.log(Number(input_num)>Number(max_page));
        if(Number(input_num)<1){
            console.log('输入页码过小');
        }
        else if(Number(input_num)>Number(max_page)){
            console.log('输入页码过大');
        }else if(Number(input_num)==Number(now_page)){
            console.log('输入为当前页');
        }
        else{
            getPageData(input_num);//拉取数据的方法
        }
    });
}