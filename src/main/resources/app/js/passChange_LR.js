var upass = document.getElementById("upass");
var vie = document.getElementById("vie");
var i = false;
function qw(){
    if(i==false){
        upass.type="text";
        vie.innerHTML = "隐藏";
        i=true;
    }else{
        upass.type="password";
        vie.innerHTML = "显示";
        i=false;
    }
}

 
var imgs =["./img/1.png","./img/2.png","./img/3.png","./img/4.jpg","./img/5.jpg","./img/6.png","./img/7.jpg",
              ];    
 
var index=Math.floor(Math.random()*7);
var img = imgs[index];
        function time(){
               
              document.body.style.backgroundImage="url("+img+")";
              
        }    
 
document.body.onload = function(){
  time();
}
