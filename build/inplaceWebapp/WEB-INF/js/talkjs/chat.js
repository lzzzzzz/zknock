/*发送消息*/



function send(headSrc,str){
	var html="<div class='send'><div class='msg'><img src="+headSrc+" />"+
	"<p><i class='msg_input'></i>"+str+"</p></div></div>";
	upView(html);
}
/*接受消息*/
function show(headSrc,str){
	var html="<div class='show'><div class='msg'><img src="+headSrc+" />"+
	"<p><i class='msg_input'></i>"+str+"</p></div></div>";
	upView(html);
}
/*更新视图*/
function upView(html){
	$('.message').append(html);
	$('body').animate({scrollTop:$('.message').outerHeight()-window.innerHeight},200)
}
function sj(){
	return parseInt(Math.random()*10)
}
$(function(){
	$('.footer').on('keyup','input',function(){
		if($(this).val().length>0){
			$(this).next().css('background','#114F8E').prop('disabled',true);
		
		}else{
			$(this).next().css('background','#ddd').prop('disabled',false);
		}
	})
	$('.footer p').click(function(){
	    var url=$("#dwac").attr("wac");
	    var message=$(this).prev().val();
	    if(message.length>30){
	        console.log("消息太长了~")
        }else{
            console.log("url:"+url);
            sendMessage(url,message);
        }
	})
})

function sendMessage(url,message){
    $.ajax({
        type : "POST",  //提交方式
        dataType: 'json',
        url : url,//路径
        data : {
            "message" : message
        },//数据，这里使用的是Json格式进行传输
        success : function(result) {//返回数据根据结果进行相应的处理
            console.log("result:"+result.message);
            if ( result.result_code==1 ) {
                show("/images/touxiangm.png",message)
                $(kk_input).val("");
            } else {
                $("#tipMsg").text("发送信息失败");
            }
        },
        error :function(e){
            console.log("e:"+e);
            $("#tipMsg").text("发送信息出错");
        }
    });
}
