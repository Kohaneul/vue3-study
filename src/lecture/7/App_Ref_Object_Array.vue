<template>
	<div>{{ state.value }}</div>
	<div>{{ count }}</div>
</template>

<script>
import { ref, reactive } from 'vue';
export default {
	setup() {
		//ref -> Object에서 사용
		const count = ref(0);
		const state = reactive({ count: count });
		count.value++;
		count.value++;
		console.log('value : ' + count.value);
		console.log(state.count);

		// ref->Array에서 사용
		const message = ref('Hello');
		const arr = reactive([message]);
		//ref를 배열에서 사용하여 값에 접근하고 싶을때 .value를 써줘야 값이 나옴
		console.log('arr[0]:' + arr[0].value);
		return { count, state, arr };
	},
};
</script>

<style lang="scss" scoped></style>
