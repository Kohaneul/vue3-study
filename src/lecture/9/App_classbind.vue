<template>
	<!-- <div class="text" :class="{ active: isActive, 'text-danger': hasError }"> -->
	<div class="text" :class="[activeClass, errorClass, classObject]">
		텍스트 입니다11
	</div>
	<div class="text" :class="isActive ? 'error' : 'class'">텍스트 입니다</div>

	<button @click="toggle">toggle</button>
	<button @click="hasError = !hasError">toggleError</button>
</template>

<script>
import { reactive, computed, ref } from 'vue';
export default {
	setup() {
		const isActive = ref(true);
		const hasError = ref(false);
		const activeClass = ref('active');
		const errorClass = ref('error');
		const toggle = () => {
			isActive.value = !isActive.value;
		};
		const toggle2 = () => {
			hasError.value = !hasError.value;
		};
		const classObject = computed(() => {
			return {
				active: true && true,
				'text-object': true && true,
				'text-blue': true,
			};
		});

		return {
			isActive,
			hasError,
			classObject,
			toggle,
			toggle2,
			activeClass,
			errorClass,
		};
	},
};
</script>

<style scoped>
.active {
	font-weight: 900;
}
.error {
	color: red;
}
.text-danger {
	color: red;
}
</style>
