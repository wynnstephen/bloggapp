import createView from "../createView";

export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <div>
                ${props.posts.map(post => `<h3>${post.title}</h3>`).join('')}   
            </div>
        </main>
    `;
}

export function PostsEvent(){

    createPostEvent();

}

function createPostEvent() {
    $("#create-post-btn").click(function ())
    {
        let post = {
            title: $("#title").val(),
            content: $("#content").val()
        }

        let request = {
            method: "POST",
            headers {"Content-Type": "application.json"},
            body: JSON.stringify(post)
        }

        fetch("http://localhost:8080/api/posts", request)
            .then(res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts");
        });
    }
}