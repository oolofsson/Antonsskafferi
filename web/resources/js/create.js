$(document).ready(function () {
    
    //Initiate page
    $("#logoutdiv").show();
    $("#imageuploaddiv").hide();
    $("#newalacartediv").hide();
    $("#deletealacartediv").hide();
    $("#newdrinkdiv").hide();
    $("#deletedrinkdiv").hide();
    $("#dailyspecialdiv").hide();
    $("#newdagensdiv").hide();
    $("#deletedagensdiv").hide();
    $("#ShowAlaCarte").hide();
    $("#PreAlaCarte").hide();
    $("#ShowLunch").hide();
    $("#PreLunch").hide();
    $("#HideAlaCarte").hide();
    $("#HideLunch").hide();
    $("#HideWaiters").hide();
    $("#ShowWaiters").hide();
    $("#PreWaiters").hide();
    $("#newwaiterdiv").hide();
    $("#deletewaiterdiv").hide();
    
    
    //Button events
    $("#bildknapp").click(function(){
        $("#imageuploaddiv").show();
        $("#newalacartediv").hide();
        $("#deletealacartediv").hide();
        $("#newdrinkdiv").hide();
        $("#deletedrinkdiv").hide();
        $("#dailyspecialdiv").hide();
        $("#newdagensdiv").hide();
        $("#deletedagensdiv").hide();
        $("#ShowAlaCarte").hide();
        $("#PreAlaCarte").hide();
        $("#ShowLunch").hide();
        $("#PreLunch").hide();
        $("#HideAlaCarte").hide();
        $("#HideLunch").hide();
        $("#HideWaiters").hide();
        $("#ShowWaiters").hide();
        $("#PreWaiters").hide();
        $("#newwaiterdiv").hide();
        $("#deletewaiterdiv").hide();
        document.cookie = "bild";
    });
    $("#alacarteknapp").click(function(){
        $("#newalacartediv").show();
        $("#deletealacartediv").show();
        $("#newdrinkdiv").show();
        $("#deletedrinkdiv").show();
        $("#dailyspecialdiv").hide();
        $("#imageuploaddiv").hide();
        $("#newdagensdiv").hide();
        $("#deletedagensdiv").hide();
        $("#PreAlaCarte").hide();
        $("#ShowAlaCarte").show();
        $("#PreAlaCarte").hide();
        $("#ShowLunch").hide();
        $("#PreLunch").hide();
        $("#HideAlaCarte").hide();
        $("#HideLunch").hide();
        $("#HideWaiters").hide();
        $("#ShowWaiters").hide();
        $("#PreWaiters").hide();
        $("#newwaiterdiv").hide();
        $("#deletewaiterdiv").hide();
        document.cookie = "alacarte";
    });
    $("#dagensknapp").click(function(){
        $("#imageuploaddiv").hide();
        $("#newalacartediv").hide();
        $("#deletealacartediv").hide();
        $("#newdrinkdiv").hide();
        $("#deletedrinkdiv").hide();
        $("#newdagensdiv").show();
        $("#deletedagensdiv").show();
        $("#dailyspecialdiv").show();
        $("#ShowAlaCarte").hide();
        $("#PreAlaCarte").hide();
        $("#PreLunch").hide();
        $("#ShowLunch").show();
        $("#HideLunch").hide();
        $("#HideAlaCarte").hide();
        $("#HideLunch").hide();
        $("#HideWaiters").hide();
        $("#ShowWaiters").hide();
        $("#PreWaiters").hide();
        $("#newwaiterdiv").hide();
        $("#deletewaiterdiv").hide();
        document.cookie = "dagens";
    });
    $("#servitrisknapp").click(function(){
        $("#imageuploaddiv").hide();
        $("#newalacartediv").hide();
        $("#deletealacartediv").hide();
        $("#newdrinkdiv").hide();
        $("#deletedrinkdiv").hide();
        $("#newdagensdiv").hide();
        $("#deletedagensdiv").hide();
        $("#dailyspecialdiv").hide();
        $("#ShowAlaCarte").hide();
        $("#PreAlaCarte").hide();
        $("#PreLunch").hide();
        $("#ShowLunch").hide();
        $("#HideLunch").hide();
        $("#HideAlaCarte").hide();
        $("#HideLunch").hide();
        $("#HideWaiters").hide();
        $("#ShowWaiters").show();
        $("#PreWaiters").hide();
        $("#newwaiterdiv").show();
        $("#deletewaiterdiv").show();
        document.cookie = "servitris";
    });
    $("#ShowAlaCarte").click(function(){
        $("#PreAlaCarte").show();
        $("#HideAlaCarte").show();
        $("#ShowAlaCarte").hide();
    });
    $("#HideAlaCarte").click(function(){
        $("#PreAlaCarte").hide();
        $("#HideAlaCarte").hide();
        $("#ShowAlaCarte").show();
    });
    
    $("#ShowLunch").click(function(){
        $("#PreLunch").show();
        $("#HideLunch").show();
        $("#ShowLunch").hide();
    });
    $("#HideLunch").click(function(){
        $("#PreLunch").hide();
        $("#HideLunch").hide();
        $("#ShowLunch").show();
    });
    
    $("#ShowWaiters").click(function(){
        $("#PreWaiters").show();
        $("#HideWaiters").show();
        $("#ShowWaiters").hide();
    });
    $("#HideWaiters").click(function(){
        $("#PreWaiters").hide();
        $("#HideWaiters").hide();
        $("#ShowWaiters").show();
    });
    
    $("#schemaknapp").click(function(){
       window.location.href = "javacalendar.jsp"; 
    });
    
    //Change events
    $("#delete_drink").change(function(){
        $('#delete_drink_form\\:input_drink').val($('#delete_drink').val());
    });
    
    $("#type_alacarte").change(function(){
        $('#create_alacarte_form\\:alacartetype').val($('#type_alacarte').val());
    });
    
    $("#delete_alacarte").change(function(){
        $('#delete_alacarte_form\\:input_alacarte').val($('#delete_alacarte').val());
    });
    
    $("#delete_dagens").change(function(){
        $('#delete_dagens_form\\:input_dagens').val($('#delete_dagens').val());
    });
    
    $("#delete_waiter").change(function(){
        $('#delete_waiter_form\\:input_waiter').val($('#delete_waiter').val());
    });
    
    $('.day_select').change(function(){
        for(var i = 1; i <= 7; i++){
           $('#daily_special_form\\:input' + i).val($('#select' + i).val());
        }
    });
    
   
});

$(document).ready(function() {
    // Executes after
    
    switch(document.cookie){
    case "bild":
        $("#bildknapp").trigger("click");
        clearForm();
        break;
    case "alacarte":
        $("#alacarteknapp").trigger("click");
        clearForm();
        break;
    case "dagens":
        $("#dagensknapp").trigger("click");
        clearForm();
        break;
    case "servitris":
        $("#servitrisknapp").trigger("click");
        clearForm();
        break;
    }
  
});

function clearForm()
{
    $(':input').not(':button, :submit, :reset, :hidden, :checkbox, :radio').val('');
    $(':checkbox, :radio').prop('checked', false);
}