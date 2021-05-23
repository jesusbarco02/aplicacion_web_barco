$(document).ready(function () {
    $("#sidebar").mCustomScrollbar({
        theme: "minimal"
    });

    $('#dismiss, .overlay').on('click', function () {
        $('#sidebar').removeClass('active');
        $('.overlay').removeClass('active');
    });

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').addClass('active');
        $('.overlay').addClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });
});

$(document).ready(function() {
	$('#delete-modal').on('show.bs.modal', function(event) {
		let button = $(event.relatedTarget);
		let data = button.data('id');

		let modal = $(this);

		let a = modal.find('.modal-body a')[0];
		a.href = a.href + data;

	});
});

