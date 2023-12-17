<template>
	<div>{{ message }}</div>
	<button @click="addMessage">add click</button>
</template>

<script>
import { reactive, ref } from 'vue';
export default {
	setup() {
		let message = ref('Hello Vue');
		const addMessage = () => {
			message.value = message.value + '!';
		};
		console.log('message : ' + message.value);
		console.log(typeof message.value);

		return { message, addMessage };
	},
};
</script>

<style lang="scss" scoped></style>
