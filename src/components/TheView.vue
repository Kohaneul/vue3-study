<template>
	<main>
	<div class="container py-4">
		<MyButton type="my-button" id="my-button" @click="sayHello"></MyButton>
		<LabelInput label="이름" data-id="data-id 입니다"></LabelInput>
	</div>
</main>
</template>

<script>
import MyButton from './MyButton.vue'
import LabelInput from './LabelInput.vue';
	export default {
		components:{MyButton,LabelInput},
		setup(){
			const sayHello = ()=>{
				alert('안녕하세요');
			}
			return {sayHello}
		}

		
		
	}
</script>

<style lang="scss" scoped>

</style>