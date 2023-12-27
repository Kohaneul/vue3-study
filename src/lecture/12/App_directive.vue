<template>
	<p>{{ msg }}</p>
	<div v-text="msg"></div>
	<p v-html="htmlStr"></p>
	<p v-text="htmlStr"></p>
	<p v-pre>{{ msg }} !!</p>
	<p v-once>{{ msg }}</p>
</template>

<script>
import { ref } from 'vue';
export default {
	setup() {
		const msg = ref('안녕하세요');
		const htmlStr = ref('<strong>' + msg.value + '</strong>');
		return { msg, htmlStr };
	},
};
</script>

<style lang="scss" scoped></style>
