$(function(){
    
    $("#login_form\\:choose_waiter").change(function(){
       $('#login_form\\:username').val($('#login_form\\:choose_waiter').val());
    }); 
    
    $("#admin_login_knapp").click(function(){
        $('#login_form\\:choose_waiter').hide();
        $('#login_form\\:admin_username_text').show();
        $('#login_form\\:username').show();
        $('#login_form\\:password_text').show();
        $('#login_form\\:password').show();
        $('#login_form\\:login_knapp').show();
        $("#admin_login_knapp").hide();
        $("#personal_login_knapp").show();
    });
    
    $("#personal_login_knapp").click(function(){
        $('#login_form\\:choose_waiter').show();
        $('#login_form\\:admin_username_text').hide();
        $('#login_form\\:username').hide();
        $('#login_form\\:password_text').show();
        $('#login_form\\:password').show();
        $('#login_form\\:login_knapp').show();
        $("#personal_login_knapp").hide();
        $("#admin_login_knapp").show();
    });
    
    
    $('#login_form\\:choose_waiter').hide();
    $('#login_form\\:admin_username_text').hide();
    $('#login_form\\:username').hide();
    $('#login_form\\:password_text').hide();
    $('#login_form\\:password').hide();
    $('#login_form\\:login_knapp').hide();
});