<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <title>Home</title>
    <style>
        html {
            background: linear-gradient(#3B4974, #0C0C0C);
            height: 100vh;
            font-family: Helvetica;
        }
        
        .container {
            display: flex;
            justify-content: space-around;
            margin: 0 auto;
            width: 70%;
            padding: 25px;
        }
        
        .bars {
            display: flex;
            flex-direction: column;
            margin: 0 auto;
        }
        
        .col {
            display: flex;
            justify-content: center;
            background: lightblue;
            width: 50%;
            margin-top: 10px;
            margin-left: 30px;
        }
        
        .col .content {
            width: 80%;
        }
        
        .bar {
            display: flex;
            width: 100%;
            height: 120px;
            background: #D3D3D3;
            margin-top: 10px;
            cursor: pointer;
        }
        
        .bar-over {
            width: 120%;
            background: lightblue;
        }
        
        .bar img {
            height: 100%;
            width: 150px;
        }
        
        .bar p {
            margin-top: -15px;
        }
        
        .details {
            display: flex;
            flex-direction: column;
            width: 500px;
            margin: 0 30px;
        }
        
        #game-pub {
            margin-top: -22px;
            font-size: 12px;
        }
        
        #game-price {
            font-weight: 800;
        }
        
        #game-tags {
            color: #6F6F6F;
        }
        
        #game-details {
            min-height: 200px;
        }
        
        #game-tags span {
            color: black;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="bars">
            <div class="bar bar-over" data-value='0'>
                <img src="https://external-preview.redd.it/20jpHCewNcQrZiKxEa02LcajaEl8eRQOyaqYRS9Cn4Y.jpg?width=640&crop=smart&auto=webp&s=f7cdc86929a60fe0745a76631bd1372bb3716ab4" alt="">
                <div class="details">
                    <h3 class="details-title">Jogos</h3>
                    <a class="navbar-brand" href="jogo/list">Adicionar Jogos</a>
                </div>
            </div>
            
            <div class="bar" data-value='1'>
                <img src="https://i.pinimg.com/736x/4a/96/7c/4a967cd27b7ba3c9d8c22209c496ac47.jpg" alt="">
                <div class="details">
                    <h3 class="details-title">Plataformas</h3>
                    <a class="navbar-brand" href="plataforma/list">Adicionar Plataformas</a>
                </div>
            </div>
               
            <div class="bar" data-value='2'>
                <img src="https://preview.redd.it/paz-entre-as-capivaras-guerra-aos-oligarcas-viva-o-comunismo-v0-0s77x8so7um81.jpg?auto=webp&s=9b39b366b0e29f0494520286bceef9ec04a0988f" alt="">
                <div class="details">
                    <h3 class="details-title">Categorias</h3>
                    <a class="navbar-brand" href="categoria/list">Lista de categorias</a>
                </div>
            </div>      
        </div>
        
        <div class="col">
            <div class="content">
                <h2 id="game-title"></h2>
                <p id="game-pub"></p>
                <p id="game-details"></p>
                <p id="game-price"></p>
                <p id="game-tags"></p>
            </div>
        </div>
    </div>

    <script>
        const bar = document.querySelectorAll('.bar');
        const title = document.querySelector('#game-title');
        const pub = document.querySelector('#game-pub');
        const details = document.querySelector('#game-details');
        const price = document.querySelector('#game-price');
        const tags = document.querySelector('#game-tags');

        const gameDetails = [
            {
                title: 'Jogos',
                pub: 'Publisher: Team Cherry',
                des: 'A seção Jogos é onde você pode explorar, criar ou adicionar novos jogos que está desenvolvendo ou jogando. Essa área pode conter descrições de projetos de jogos, protótipos, mecânicas experimentais e atualizações sobre o desenvolvimento de seus games. É um espaço dedicado para discutir a criação de jogos, seja utilizando IA, design de personagens, mecânicas inovadoras ou até mesmo jogos simples, como o jogo da cobrinha.',
                price: 'Tags',
                tags: ['Games']
            },
            {
                title: 'Plataforma',
                pub: 'Publisher: Luna Hakuna',
                des: 'A aba Plataformas permite que os usuários organizem e gerenciem diferentes plataformas de jogos, como PC, consoles e dispositivos móveis. Os usuários podem adicionar, editar ou remover plataformas, além de associar jogos a cada uma delas. A aba também oferece análises sobre popularidade e desempenho, tornando a navegação mais intuitiva e facilitando a identificação das preferências dos jogadores. Com filtros e opções de pesquisa, a experiência de descoberta e análise de jogos é otimizada, permitindo que os usuários encontrem rapidamente plataformas específicas.',
                price: 'Tags',
                tags: ['Consoles', 'Pc', 'Mobile']
            },
            {
                title: 'Categorias',
                pub: 'Publisher: Luna Matata',
                des: 'A aba de Criação e Análise de Categorias de Jogos permite que os usuários organizem jogos em categorias personalizadas, como Ação e Aventura. Os usuários podem adicionar, editar ou remover jogos, além de acessar análises sobre popularidade e avaliações. Com filtros e opções de pesquisa, a navegação se torna mais fácil, ajudando a identificar tendências e preferências na escolha de títulos.',
                price: 'Tags',
                tags: ['Categorias', 'Listas de Jogos']
            },
        ];

        window.onload = () => {
            title.innerHTML = gameDetails[0].title;
            pub.innerHTML = gameDetails[0].pub;
            details.innerHTML = gameDetails[0].des;
            price.innerHTML = gameDetails[0].price;
            tags.innerHTML = "<span>Tags: </span>" + gameDetails[0].tags.join(', ');
        }

        bar.forEach(bar => bar.addEventListener('mouseover', barOver));

        function barOver(e) {
            let arrRef = e.currentTarget.getAttribute('data-value');
            bar.forEach(bar => bar.classList.remove('bar-over'));
            
            e.currentTarget.classList.add('bar-over');
            title.innerHTML = gameDetails[arrRef].title;
            pub.innerHTML = gameDetails[arrRef].pub;
            details.innerHTML = gameDetails[arrRef].des;
            price.innerHTML = gameDetails[arrRef].price;
            tags.innerHTML = "<span>Tags: </span>" + gameDetails[arrRef].tags.join(', ');
        }
    </script>
</body>
</html>
