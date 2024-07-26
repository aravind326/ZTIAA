<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div class="toast-container position-fixed bottom-0 end-0 p-3">
	<div class="toast align-items-center bg-${param.type}-subtle border-0" role="alert"
		aria-live="assertive" aria-atomic="true" data-bs-autohide="false">
		<div class="d-flex">
			<div class="toast-body">${param.message}
			</div>
			<button type="button" class="btn-close me-2 m-auto"
				data-bs-dismiss="toast" aria-label="Close"></button>
		</div>
	</div>
</div>



<script>
    window.onload = (event)=> {
    	 let myAlert = document.querySelector('.toast');
    	 let bsAlert = new  bootstrap.Toast(myAlert);
    	 bsAlert.show();
   	}
</script>