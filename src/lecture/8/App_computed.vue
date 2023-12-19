<template>
	<div>
		<h2>{{ teacher.name }}</h2>
		<h3>강의가 있습니까?</h3>
		<p>{{ hasLecture }}</p>
		<p>{{ hasLecture }}</p>
		<p>{{ hasLecture }}</p>
		<p>{{ existLecture() }}</p>
		<button v-on:click="counter++">Counter : {{ counter }}</button>
		<div>
			<h2>이름은 ?</h2>
			<p>{{ fullName }}</p>
		</div>
	</div>
</template>

<script>
import { reactive, computed, ref } from 'vue';
export default {
	setup() {
		const teacher = reactive({
			name: '짐코딩',
			lectures: ['HTML/CSS', 'JavaScript', 'Vue3'],
		});

		//computed 안에서 계산된 값이 캐싱됨 > 해당 함수를 여러번 호출시 캐시(보관)하고 다음번에 요청시 캐시값을 반환함
		const hasLecture = computed(() => {
			console.log('computed');
			//반응형 데이터가 변경되는 시점에 다시 계산함
			return teacher.lectures.length > 0 ? '있음' : '없음';
		});

		const existLecture = () => {
			console.log('method');
			return teacher.lectures.length > 0 ? '있음' : '없음';
		};

		const counter = ref(0);

		const firstName = ref('홍');
		const lastName = ref('길동');
		const fullName = computed({
			get() {
				return firstName.value + ' ' + lastName.value;
			},
			set(value) {
				console.log('value : ' + value);
				//구조분해 할당
				[firstName.value, lastName.value] = value.split(' ');
				console.log('first : ' + firstName.value);
				console.log('last : ' + lastName.value);
			},
		});

		console.log('Console 출력 : ' + fullName.value);
		fullName.value = '짐 코딩'; //setter 함수 실행됨

		return { teacher, hasLecture, existLecture, counter, fullName };
	},
};
</script>

<style lang="scss" scoped></style>
