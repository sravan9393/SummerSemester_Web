var wishes = [ "learn how to use JQuery", "build a website", "Become a Web Developer" ]

function addToList(item) {
    $('#items').append("<li>" + item + "<span class='label actionlist'><select id='actions'><option value='add'>Add</option><option value='update'>Update</option><option value='delete'>Delete</option></select></span><span class='label pending'>Pending</span></li>");
}

function updateTotal() {
    completed = $('.success').length;
    pending = $('.pending').length;
    deleted = $('.removed').length;

    if (completed > 0 || pending > 0 || deleted > 0) {
        $('.total').text(" Pending: " + pending + " Completed: " + completed + " Deleted: " + deleted);
    }
}

$(document).ready(function(){
    wishes.forEach(function(element) {
        addToList(element);
    });
    updateTotal();

    $(document).on('click','#add-to-list',function(){
        item = $("#item").val();

        $("#item").val(""); /* clear value */
        $("#item").focus();

        addToList(item);
        updateTotal();
    });

    $(document).on('click','.pending',function(){
        $(this).parent().append("<span class='label success'>Done!</span>");
        $(this).parent().attr("class", 'completed');
        $(this).remove();
        updateTotal();
    });

    $(function() {
        $(document).on('click', '#actions', function(event) {
            var action = this.options[this.selectedIndex].value;
            if( action == "delete" ) {
                $(this).parent().parent().append("<span class='label removed'>Removed</span>");
                $(this).parent().parent().attr("class", 'completed');
                $(this).parent().siblings('.pending').remove();
                $(this).parent().parent().remove();
                updateTotal();

            }
        });
    });

});
