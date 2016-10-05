

$(document).ready(function () {
    $("#logoutdiv").show();
        $("#imageuploaddiv").hide();
        $("#newdishdiv").hide();
        $("#deletedishdiv").hide();
        $("#newdrinkdiv").hide();
        $("#deletedrinkdiv").hide();
        $("#dailyspecialdiv").hide();
        $("#newdagensdiv").hide();
        $("#deletedagensdiv").hide();
    
    $("#bildknapp").click(function(){
        $("#imageuploaddiv").show();
        $("#newdishdiv").hide();
        $("#deletedishdiv").hide();
        $("#newdrinkdiv").hide();
        $("#deletedrinkdiv").hide();
        $("#dailyspecialdiv").hide();
        $("#newdagensdiv").hide();
        $("#deletedagensdiv").hide();
    });
    $("#alacarteknapp").click(function(){
        $("#newdishdiv").show();
        $("#deletedishdiv").show();
        $("#newdrinkdiv").show();
        $("#deletedrinkdiv").show();
        $("#dailyspecialdiv").hide();
        $("#imageuploaddiv").hide();
        $("#newdagensdiv").hide();
        $("#deletedagensdiv").hide();
    });
    $("#dagensknapp").click(function(){
        $("#imageuploaddiv").hide();
        $("#newdishdiv").hide();
        $("#deletedishdiv").hide();
        $("#newdrinkdiv").hide();
        $("#deletedrinkdiv").hide();
        $("#newdagensdiv").show();
        $("#deletedagensdiv").show();
        $("#dailyspecialdiv").show();
    });
    
    $("#delete_drink").change(function(){
        $('#delete_drink_form\\:input_drink').val($('#delete_drink').val());
    });
    
    $("#delete_dish").change(function(){
        $('#delete_dish_form\\:input_dish').val($('#delete_dish').val());
    });
    
    $('.day_select').change(function(){
        for(var i = 1; i <= 7; i++){
           $('#daily_special_form\\:input' + i).val($('#select' + i).val());
        }
    });
});




