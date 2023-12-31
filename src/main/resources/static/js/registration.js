let isIdValidate = null;
let isPasswordValidate = null;
let isIdCheck = null;
let isEmailCheck = null;
let isPwdCheck = null;

async function validateId() {
    const id = document.getElementById('username').value;
    const label = document.getElementById('labelUsername');
    const validation = /^[a-zA-z0-9]{6,20}$/;

    if(validation.test(id)) {
        if(isIdCheck === false) {
            isIdCheck = null;
        }

        isIdValidate = true;
        label.innerText = '사용 가능한 아이디 입니다.';

        if(label.classList.contains('text-gray-500')) {
            label.classList.replace('text-gray-500', 'text-green-500');
        } else {
            label.classList.replace('text-red-500', 'text-green-500');
        }
    } else if(id === null) {
        isPasswordValidate = false;
    } else {
        isIdValidate = false;
        label.innerText = '영문, 숫자만 4글자 이상 20글자 이하만 입력 가능합니다.';

        if(label.classList.contains('text-gray-500')) {
            label.classList.replace('text-gray-500', 'text-red-500');
        } else {
            label.classList.replace('text-green-500', 'text-red-500');
        }
    }
}

async function validatePassword() {
    const password = document.getElementById('password').value;
    const label = document.getElementById('labelPassword');
    const validation = /^[a-zA-z0-9]{6,20}$/;

    if(validation.test(password)) {
        isPasswordValidate = true;
        label.innerText = '사용 가능한 비밀번호 입니다.';
        if(label.classList.contains('text-gray-500')) {
            label.classList.replace('text-gray-500', 'text-green-500');
        } else {
            label.classList.replace('text-red-500', 'text-green-500');
        }
    } else if(password === '') {
        isPasswordValidate = false;
    } else {
        isPasswordValidate = false;
        label.innerText = '영문, 숫자 6-20자로 되어야 합니다.';

        if(label.classList.contains('text-gray-500')) {
            label.classList.replace('text-gray-500', 'text-red-500');
        } else {
            label.classList.replace('text-green-500', 'text-red-500');
        }
    }

    const confirmPassword = document.getElementById('confirmPassword').value;

    if(confirmPassword !== '') {
        await checkPassword();
    }
}

async function checkId() {

    if(isIdValidate === false) {
        alert('아이디는 영문, 숫자만 4글자 이상 20글자 이하만 입력 가능합니다.');
        return false;
    }

    const id = document.getElementById('username').value;
    await axios.get(`/member/id/${id}`)
        .then((res) => {
            isIdCheck = res.data;

            if(isIdCheck === false) {
                alert('이미 사용중인 아이디 입니다.');
            } else {
                alert('사용 가능한 아이디 입니다.');
            }
        })
        .catch((err) => {
            if(err.status === 500) {
                alert('에러');
            }
        })
}

async function checkPassword() {
    const originPwd = document.getElementById('password').value;
    const confirmPwd= document.getElementById('confirmPassword').value;
    const label =  document.getElementById('labelConfirmPassword');

    if(confirmPwd !== '' && originPwd !== confirmPwd) {
        isPwdCheck = false;
        label.innerText = '비밀번호가 다릅니다.';
        label.classList.replace('text-green-500', 'text-red-500');
    } else if(confirmPwd === '') {
        isPwdCheck = false;
        label.innerText = '';
    } else {
        isPwdCheck = true;
        label.innerText = '비밀번호가 같습니다.';
        label.classList.replace('text-red-500', 'text-green-500');
    }
}

async function checkEmail() {
    const email = document.getElementById('email').value;

    let regex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
    if(!regex.test(email)) {
        alert('이메일 형식이 일치하지 않습니다.');
        return false;
    }

    await axios.get(`/member/email/${email}`)
        .then((res) => {
            isEmailCheck = res.data;

            if(isEmailCheck === false) {
                alert('이미 사용중인 이메일 입니다.')
            } else {
                alert('사용 가능한 이메일 입니다.')
            }
        })
        .catch((err) => {
            if(err.status === 500) {
                alert('에러');
            }
        })
}

const preventSubmit =  async function submit(event) {

    if(isIdCheck === null) {
        alert('아이디 중복체크를 하셔야 합니다.');
        event.preventDefault();
        return false;
    } else if(isIdCheck === false) {
        alert('중복된 아이디 입니다.');
        event.preventDefault();
        return false;
    }

    if(isEmailCheck === null) {
        alert('이메일 중복체크를 하셔야 합니다.');
        event.preventDefault();
        return false;
    } else if(isEmailCheck === false) {
        alert('중복된 이메일 입니다.');
        event.preventDefault();
        return false;
    }

    if(isPwdCheck === false) {
        alert('비밀번호가 일치하지 않습니다.');
        event.preventDefault();
        return false;
    }

    if(isIdValidate === false) {
        alert('아이디 제약규칙에 위배 됩니다.');
        event.preventDefault();
        return false;
    }

    if(isPasswordValidate === false) {
        alert('비밀번호 제약규칙에 위배 됩니다.');
        event.preventDefault();
        return false;
    }

    if(document.getElementById('country').value === 'none') {
        alert('국적을 확인해주세요.');
        event.preventDefault();
        return false;
    }

    if(document.getElementById('gender').value === 'none') {
        alert('성별을 확인해주세요.');
        event.preventDefault();
        return false;
    }

    const birthDay = new Date(document.getElementById('datepicker').value).toDateString();
    const today = new Date(Date.now()).toDateString();
    const parsedBirthday = new Date(birthDay).getTime();
    const parsedToday = new Date(today).getTime();

    if(parsedBirthday >= parsedToday) {
        alert('오늘 날짜 이후는 설정할 수 없습니다.');
        event.preventDefault();
        return false;
    }
}

let ele = document.getElementById('submit');
ele.addEventListener('click', preventSubmit);