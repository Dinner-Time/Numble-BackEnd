const main = {
    init: () => {
        const form = document.querySelector('#form');
        document.querySelector('#saveBtn').addEventListener('click', () => {
            main.save(form);
        });
    },
    save: (form) => {
        const data = {
            title: form.title.value,
            author: form.author.value,
            content: form.content.value,
        };

        fetch('/api/v1/posts', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
            .then((result) => {
                alert('등록 완료');
                window.location.href = '/';
            })
            .catch((err) => {
                alert('등록 실패');
                console.log(err);
            });
    },
};

main.init();
