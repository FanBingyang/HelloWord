function card(name,suit,value) { //创建扑克牌对象
    this.name = name;
    this.suit = suit;
    this.value = value;
}
var deck = [
    new card('Ace','Hearts',11),
    new card('Two','Hearts',2),
    new card('Three','Hearts',3),
    new card('Four','Hearts',4),
    new card('King','Hearts',10),
    new card('Ace','Diamonds',11),
    new card('Two','Diamonds',2),
    new card('Three','Diamonds',3),
    new card('Four','Diamonds',4),
    new card('King','Diamonds',10),
    new card('Ace','Clubs',11),
    new card('Two','Clubs',2),
    new card('Three','Clubs',3),
    new card('Four','Clubs',4),
    new card('King','Clubs',10),
    new card('Ace','Spades',11),
    new card('Two','Spades',2),
    new card('Three','Spades',3),
    new card('Four','Spades',4),
    new card('King','Spades',10)
];
function getRandom(num) {
    var my_num = Math.floor(Math.random()*num);
    return my_num;
}
var hand = {
    cards : new Array(),
    current_total : 0,//总数

    sumCardTotal: function () {
        this.current_total = 0;
        for(var i=0;i<this.cards.length;i++){
            var c = this.cards[i];//从数组中得到当前的牌
            this.current_total += c.value;//将这个值增加到current_total
        }
        $("#hdrTotal").html("Total:"+this.current_total);
        if(this.current_total>21){
            $("#btnStick").trigger("cilck");
            $("#imgResult").attr('src','img/chahao.jpg');
            $("#hdrResult").html("BUST!").attr('class','lose');
        }else if (this.current_total==21){
            $("#btnStick").trigger("cilck");
            $("#imgResult").attr('src','img/duihao.jpg');
            $("#hdrResult").html("BlackJack!").attr('class','win');;
        } else if(this.current_total<=21 && this.cards.length==5){
            $("#btnStick").trigger("cilck");
            $("#imgResult").attr('src','img/duihao.jpg');
            $("#hdrResult").html("BlackJack -5 card trick!").attr('class','win');;
        }else{}
        $("#hdrTotal").html("Total:"+this.current_total);
    }
};
function end() {
    $("#btnHit").toggle();
    $("#btnStick").toggle();
    $("#btnRestart").toggle();  //切换所有控件的状态，结束游戏
}
$("#btnStick").click(function () {
    $("#hdrResult").html('Stick').attr('class','win');
    $("#result").toggle();
    end();
});

var used_cards = new Array();
function deal() {
    for (var i=0;i<2;i++){
        hit();
    }
}
function hit() {
    var good_card = false;
    do {
        var index = getRandom(52);
        if(!$.inArray(index,used_cards)>-1){
            good_card = true;
            var c = deck[index];//从数组中取牌
            used_cards[used_cards.length] = index;
            hand.cards[hand.cards.length] = c;
            var $d = $("<div>");
            $d.addClass("current_hand").appendTo("#my_hand");
            $("<img>").appendTo($d).attr('src','img/cards/puke.jpg').fadeOut('slow').fadeIn('slow');
        }
    }while (!good_card) ;
    good_card = false;
    hand.sumCardTotal();//在hit函数的末尾得到一手牌的总点数
}
$("#btnDeal").click(function () {
   deal();
   $(this).toggle();
   $("#btnHit").toggle();
    $("#btnStick").toggle();  //隐藏deal按钮，但显示hit或stick按钮
});
$("#btnHit").click(function () {
    hit();
});
$("#btnStick").click(function () {
    $("#hdrResult").html('Stick!');
    $("result").toggle();
});
$("#btnRestart").click(function () {//重置所有元素
    $("#result").toggle();
    $(this).toggle();
    $("#my_hand").empty();
    $("#hdrResult").html('');
    used_cards.length = 0;//清空数组，长度为0即可
    hand.cards.length = 0;
    hand.current_total = 0;

    $("#btnDeal").toggle().trigger('click');//模拟btnDeal元素的一次点击
});
