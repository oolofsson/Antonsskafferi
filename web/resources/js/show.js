$(document).ready(function () {
    $('.parallax').parallax();
    $('.scrollspy').scrollSpy();
    $('.materialboxed').materialbox();
    $(".button-collapse").sideNav();
    $(".side-nav").click(function(){
        $('.button-collapse').sideNav('hide');
    });
});