<template>
	<div>
		<div :style="styleObject">
			Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis cumque
			vitae alias aliquid laborum dignissimos labore sapiente possimus aperiam
			sint, autem minus pariatur nostrum! Vero consectetur odit doloribus
			aspernatur accusantium?
		</div>
		<button @click="fontSize++">+</button>
		<button @click="minusFontSize">-</button>
		<div>fontSize = {{ fontSize }}</div>
	</div>
</template>

<script>
import { computed, reactive, ref } from 'vue';
export default {
	setup() {
		const fontSize = ref(13);
		const minusFontSize = () => {
			fontSize.value--;
			if (fontSize.value < 1) {
				alert('폰트사이즈는 0보다 작을 수 없습니다.');
				fontSize.value = 1;
			}
		};
		const styleObject = computed(() => {
			return { fontSize: fontSize.value + 'px', color: 'red' };
		});

		return { styleObject, fontSize, minusFontSize };
	},
};
</script>

<style lang="scss" scoped></style>
