<template>
	<div :style="{}">afjewfjalefjlawefjlawelfkawfkjle</div>
</template>

<script>
import { computed, reactive } from 'vue';
export default {
	setup() {
		// const styleObject = reactive({
		// 	color: 'red',
		// 	fontSize: '13px',
		// });
		const styleObject = computed(()=>{
	return {
		color: 'red',
			fontSize: '13px',
		});
		
		})

		return { styleObject };
	},
};
</script>

<style scoped></style>
