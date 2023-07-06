setTimeout(function() {


	let counter=document.querySelector('h6');
	let count = 4;


		setInterval(()=>{

		counter.innerText = count;
		count--
	
	
	},1000)
	
}, 4000);



