<template>
	<div>
		<ul>
			<template v-for="(evenItem, idx) in evenItems" :key="evenItem.id">
				<li>
					인덱스 :
					{{ idx + 1 }}
					, id :
					{{ evenItem.id }}
					, message :
					{{ evenItem.message }}
				</li>
			</template>
		</ul>
		<!-- <template v-for="(i, index) in items" :key="i.id">
			<li v-if="i.id % 2 === 0">
				인덱스 :
				{{ index + 1 }}
				/ id :
				{{ i.id }}
				/ message :
				{{ i.message }}
			</li>
		</template> -->
		<!-- <ul v-for="(i, index) in items" :key="i.id"> -->
		<!-- 인덱스 :
			{{
				index + 1
			}}
			/ id :
			{{
				i.id
			}}
			/ message :
			{{
				i.message
			}} -->
		<!-- </ul> -->

		<ul>
			<li v-for="(value, key, index) in myObject" :key="key">
				{{ index }} - {{ key }} - {{ value }}
			</li>
		</ul>
	</div>
</template>

<script>
import { reactive, computed } from 'vue';
export default {
	setup() {
		const items = reactive([
			{ id: 1, message: 'Java' },
			{ id: 2, message: 'HTML' },
			{ id: 3, message: 'CSS' },
			{ id: 4, message: 'JavaScript' },
		]);

		const evenItems = computed(() => items.filter(item => item.id % 2 == 0));

		const myObject = reactive({
			title: '제목',
			author: '홍길동',
			publishedAt: '2016-01-01',
		});

		return {
			items,
			evenItems,
			myObject,
		};
	},
};
</script>

<style lang="scss" scoped></style>
