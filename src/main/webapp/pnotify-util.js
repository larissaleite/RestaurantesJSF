function mostrar_mensagem(mensagem, tipo) {
	
	var opts = {
        title: false,
        text: mensagem,
        history: false,
        icon: true,
        hide: true,
        mouse_reset: false,
        buttons: {
            closer: true,
            sticker: true,
            closer_hover: false,
            sticker_hover: true
        }
    };
	
	switch (tipo) {
	    case 'error':
	        opts.type = "error";
	        break;
	    case 'info':
	        opts.type = "info";
	        break;
	    case 'success':
	        opts.type = "success";
	        break;
	    case 'notice':
	    	opts.type = "notice";
	    	break;
        default:
        	opts.type = "info";
        	break;
    }
	
	new PNotify(opts);
}

//function show_stack_context(type, message) {
//	if (typeof stack_context === "undefined")
//		stack_context = {"dir1": "down", "dir2": "left"};
//	var opts = {
//		text: message,
//		stack: stack_context,
//		buttons: {
//			closer: true,
//			closer_hover: false,
//			sticker: false,
//			sticker_hover: false 
//		},
//		delay: 5000,
//		remove: true,
//		hide: false,
//		title: false,
//		life: 1000
//	};
//	switch (type) {
//		case 'error':
//			opts.text = message;
//			opts.type = "error";
//			break;
//		case 'info':
//			opts.text =  message;;
//			opts.type = "info";
//			break;
//		case 'success':
//			opts.text =  message;
//			opts.type = "success";
//			break;
//	}
//	new PNotify(opts);
//};