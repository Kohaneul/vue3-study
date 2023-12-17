<template>
	<div>
		<div>author : {{ author }}</div>
		<div>title : {{ title }}</div>
		<div>year : {{ year }}</div>
	</div>
</template>

<script>
import { ref, reactive, toRefs, toRef } from 'vue';
export default {
	setup() {
		const book = reactive({
			author: 'Vue Team',
			year: '2020',
			title: 'Vue 3 Guide',
			description: '당신은 지금 바로 이 책을 읽습니다.',
			price: '무료',
		});
		//구조분해할당을 하게되면 반응성을 잃어버림 -> 그냥 string이 되어버림
		// const { author, title } = book;
		//반응성을 유지하려면?
		// const { author, title } = toRefs(book);
		const year = toRef(book, 'year');
		const author = toRef(book, 'author');
		const title = toRef(book, 'title');
		// console.log(typeof author);
		// console.log(typeof title);
		console.log(typeof year.value);

		return { author, title, year, book };
	},
};
</script>

<style lang="scss" scoped></style>
