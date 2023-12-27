<template>
	<div v-memo="[subscribers]">
		<p>subscribers:{{ subscribers }}</p>
		<p>views:{{ views }}</p>
		<p>likes:{{ likes }}</p>
	</div>
	<button @click="subscribers++">subcribers++</button>
	<button @click="views++">views++</button>
	<button @click="likes++">likes++</button>
	<div>
		<p>subscribers:{{ subscribers }}</p>
		<p>views:{{ views }}</p>
		<p>likes:{{ likes }}</p>
	</div>
</template>

<script>
import { ref } from 'vue';
export default {
	setup() {
		const subscribers = ref(400);
		const views = ref(4000);
		const likes = ref(20);
		return { subscribers, views, likes };
	},
};
</script>

<style lang="sass" scoped></style>
