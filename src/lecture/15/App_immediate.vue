<template>
	<div>
		{{ message }}
		{{ reverseMessage }}
	</div>
</template>

<script>
import{ ref, watch} from 'vue';
	export default {
		setup(){
			const message = ref('message');
			const reverseMessage = ref('');

			const reverseFunction = ()=>{	
				console.log('즉시 실행 함');
				reverseMessage.value = message.value.split('').reverse().join('');
			};

			watch(message, reverseFunction);
			reverseFunction(message.value);
			return {message, reverseMessage,reverseFunction}
		}
		
	
	}
</script>

<style lang="scss" scoped>

</style>