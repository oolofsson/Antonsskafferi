$(document).ready(function () {
    $('.parallax').parallax();
    $('.scrollspy').scrollSpy();
    $('.materialboxed').materialbox();
    $(".button-collapse").sideNav();
    $(".nav-wrapper").click(function(){
        $('.button-collapse').sideNav('hide');
    });
});