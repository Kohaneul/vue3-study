<template>
	<div>
	</div>
</template>

<script>
import {watch,ref} from 'vue'
	export default {
		setup(){
			const message = ref('');
			watch(message,(newValue,oldValue)=>{
				console.log('newValue:',newValue);
				console.log('oldValue:',oldValue);
				
			})
			return {
				message
			}
		}
	}
</script>

<style lang="sass" scoped>

</style>