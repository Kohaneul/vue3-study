<template>
	<div>
		<h2>반응형 메세지</h2>
		<h2>{{ reactiveMessage }}</h2>
		<button v-on:click="addReactiveMessage">add Message</button>
		<h2>일반 메세지</h2>
		<h2>{{ normalMessage }}</h2>
		<button v-on:click="addNormalMessage">add Message</button>
	</div>
</template>

<script>
import { isRef, ref, onMounted, onBeforeMount } from 'vue';
export default {
	setup() {
		console.log('setUp');
		const reactiveMessage = ref('reactive Message');
		const normalMessage = 'Hello Message';
		const addReactiveMessage = () => {
			reactiveMessage.value = reactiveMessage.value + '!';
		};
		// console.log('isRef(reactiveMessage)', isRef(reactiveMessage));

		let addNormalMessage = () => {
			normalMessage.value = normalMessage.value + '!';
		};
		// console.log('isRef(normalMessage)', isRef(normalMessage));
		onMounted(() => {
			console.log('onMounted');
		});

		onBeforeMount(() => {
			console.log('onBeforeMount');
		});
		return {
			reactiveMessage,
			normalMessage,
			addReactiveMessage,
			addNormalMessage,
		};
	},
};
</script>

<style lang="scss" scoped></style>
