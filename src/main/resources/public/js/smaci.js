(function(window, document, $, undefined){
  'use strict';

  var data;

  $("#insert-form").on( "submit", function( event ) {
    event.preventDefault();
    $.ajax({
      type: 'POST',
      url: "/insert_item",
      data: $( this ).serialize(),
      cache: false,
      success: function(resp) {
        console.log(resp);
        data = resp;
        if(resp.success === true) {
          alert('AAA');
        }
        $('#insert-form').toggleClass('hidden');
        $('#download-qr-link').attr('href', resp.data.generate_link);
        $('.download-container').toggleClass('hidden');
      }
    });
  });


})(window, document, jQuery);
