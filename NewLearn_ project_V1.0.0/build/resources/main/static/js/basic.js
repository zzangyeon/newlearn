/* 헤더 검색 아이콘 */
function search() {
    var search_txt = document.getElementById('search_txt');
    var className = document.getElementById('search_txt').className;
    
    if(className == 'search_txt on'){
        search_txt.classList.remove('on');
    }else{
        search_txt.classList.add('on');
    }
}

window.onload = function () {
    /* 메인메뉴 */
    var header = document.getElementById('header');
    var subMenu = document.getElementById('subMenu-con');
    var mainMenu = document.querySelectorAll('.menu');
    var sub = document.getElementsByClassName('sub');
    var mainMenus = document.getElementsByClassName('mainMenu');

    header.onmouseover = function(){
        subMenu.classList.add('on');
    };
    subMenu.onmouseout = function(){
        subMenu.classList.remove('on');
    };
    mainMenus.onmouseout = function(){
        subMenu.classList.remove('on');
    };


    function li_click(idx){
        mainMenu[idx].onmouseover = function(){
            sub[idx].classList.add('on');
        };

        mainMenu[idx].onmouseout = function(){
            sub[idx].classList.remove('on');
        };
    }
    
    for(var i=0; i<mainMenu.length; i++){
        li_click(i);  
    }

    /* 장바구니 */
    var cart = document.getElementById('header-cart');
    var cart_modal = document.getElementById('cartModal');

    cart.onmouseover = function(){
        cart_modal.classList.add('on');
    }

    cart.onmouseleave = function(){
        cart_modal.classList.remove('on');
    }

    /* 모바일 슬라이드 메뉴 */
    var trigger = document.getElementById('menuTrigger');
    var slide = document.getElementById('slide');
    var superMenu = document.querySelectorAll('#super')

    trigger.onclick = function(idx){
        var slideClass = slide.className;
        var triggerClass = trigger.className;
        
        if(slideClass == 'slide on'){
            slide.classList.remove('on');
            trigger.classList.remove('on');
        }else{
            slide.classList.add('on');
            trigger.classList.add('on');
        }
    }

    function super_click(idx){
        superMenu[idx].onclick = function(){
            var superClass = superMenu[idx].className;
            if(superClass == 'on'){
                superMenu[idx].classList.remove('on');
            }else{
                superMenu[idx].classList.add('on');
            }
        }
    }
    
    for(var i=0; i<superMenu.length; i++){
        super_click(i);  
    }

    /* lectureList left-menu */
    var leftmenuUnit = document.getElementById('leftmenuUnit');

    leftmenuUnit.onclick = function(){
        var leftmenuUnitC = leftmenuUnit.className;

        if(leftmenuUnitC == 'on'){
            leftmenuUnit.classList.remove('on');
        }else{
            leftmenuUnit.classList.add('on');
        }
        
    }
    
    /* 천단위 콤마 */
    var listPrice =  document.getElementsByClassName("listPrice");

    const numberWithCommas  = (x) => {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }

    for (i = 0; i < listPrice.length; i++) {
        listPrice[i].innerHTML = numberWithCommas( listPrice[i].innerHTML ) + "원";
    }


}