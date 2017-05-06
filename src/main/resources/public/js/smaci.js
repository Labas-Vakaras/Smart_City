(function(window, document, $, undefined){
  'use strict';

  $("#insert-form").on( "submit", function( event ) {
    event.preventDefault();
    $.ajax({
      type: 'POST',
      url: "/insert_item",
      data: $( this ).serialize(),
      cache: false,
      success: function(resp) {
        var jsonResponse = JSON.parse(resp);

        if(jsonResponse.success === false) {
          alert('Something went wrong');
          return
        }

        $('#insert-form').toggleClass('hidden');
        $('#download-qr-link').attr('href', jsonResponse.data.generate_link);
        $('.download-container').toggleClass('hidden');
      }
    });
  });


})(window, document, jQuery);
