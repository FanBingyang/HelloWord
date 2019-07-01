$(document).ready(function () {
    //以下点击推进代码效果和注释掉的代码作用一样，只不过事整合成了一个moveMe方法
    var clix = [0,0,0,0,0]    //数组保存head,eyes,nose.mouth和lian的位置
    $("#lian").click(function () {
        moveMe(4,this);
    });
    $("#head").click(function () {
        moveMe(0,this);
    });
    $("#eyes").click(function () {
        moveMe(1,this);
    });
    $("#nose").click(function () {
        moveMe(2,this);
    });
    $("#mouth").click(function () {
        moveMe(3,this);
    });
    function moveMe(i,obj) {
        if(clix[i] < 8){
            $(obj).animate({left:"-=254px"},500);
            clix[i] = clix[i] + 1;
        }else{
            clix[i] = 0;    //回到起点
            $(obj).animate({left:"0px"},2);
        }
    }

    var w = 254;
    var m = 9;
    $("#btnReset").click(reset);
    $("#btnRandom").click(randomize);

    function reset() {
        $(".face").each(function (index) {
           clix[index] = 0;     //重置clix数组为0
           $(this).animate({left:"0px"},2);     //挨个回转图像条，
        });
    }
    function getRandom(num) {
        var my_random_num = Math.floor(Math.random()*num);
        return my_random_num;
    }
    function randomize() {
        $(".face").each(function (index) {       //随机确定脸谱部位的位置
            var target_position = getRandom(m); //随机移动宽度
            var current_position = clix[index]; //当前位置
            clix[index] = target_position;  //更新click[index]，使用户能通过点击让脸谱各个部分推进
            if(target_position > current_position){   //当随机位置大于当前位置，那么移动的就是左移差距
                var move_to = (target_position - current_position) * w;  //将随机位置乘以宽度，得到推进宽度
                $(this).animate({left:"-="+move_to+"px"},5);  //运行定制动画代码让图像左移
            }else if(target_position < current_position){     //当随机位置小于当前位置，那么移动的就是右移差距
                var move_to = (current_position - target_position) * w;
                $(this).animate({left:"+="+move_to+"px"},5);
            }else {}



        });
    };

    /* var headclix=0,eyeclix=0,noseclix=0,mouthclix=0,clix=0;
  $("#lian").click(function () {
      if(clix < 8){
          $(this).animate({left:"-=254px"},500);
          clix += 1;
      }
      else {
          $(this).animate({left:"0px"},2);
          clix = 0;
      }
  });
  $("#head").click(function () {
     if(headclix < 8){
         $(this).animate({left:"-=254px"},500);
         headclix += 1;
     }
     else {
         $(this).animate({left:"0px"},2);
         headclix = 0;
     }
  });
   $("#eyes").click(function () {
       if(eyeclix < 8){
           $(this).animate({left:"-=254px"},500);
           eyeclix += 1;
       }
       else {
           $(this).animate({left:"0px"},2);
           eyeclix = 0;
       }
   });
   $("#nose").click(function () {
       if(noseclix < 8){
           $(this).animate({left:"-=254px"},500);
           noseclix += 1;
       }
       else {
           $(this).animate({left:"0px"},2);
           noseclix = 0;
       }
   });
   $("#mouth").click(function () {
       if(mouthclix < 8){
           $(this).animate({left:"-=254px"},500);
           mouthclix += 1;
       }
       else {
           $(this).animate({left:"0px"},2);
           mouthclix = 0;
       }
   });*/

});