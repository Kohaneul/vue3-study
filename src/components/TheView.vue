<template>
	<main>
		<div class="container py-4">
			<MyButton class="my-button" id = "my-button" @click="sayHello"></MyButton>
			<LabelInput label="이름" data-id="id입니다."></LabelInput>
		</div>
	</main>
</template>

<script>
import LabelInput from './LabelInput.vue';
import MyButton from '@/components/MyButton.vue';
	export default {
		components:{
			MyButton,LabelInput
		},
	setup(){
		const sayHello = ()=>{
			alert('안녕하세요 !');
		}
		return {sayHello};
	}
	}
</script>

<style lang="scss" scoped>

</style>