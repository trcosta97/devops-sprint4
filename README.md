# Hear Me Out - DevOps e Cloud Computing - Sprint 4

 ## Sobre a solução  
 O App "HearMeOut" resolveria o problema de acessibilidade para usuários com deficiência visual na plataforma da Plusoft, permitindo que eles possam interagir com os diversos segmentos da empresa (saúde, seguros, agronegócio, serviços, bens de consumo, educação, telecom, financeiro, utilities e varejo) de forma mais fácil e intuitiva por meio de um chatbot com funcionalidades de voz.
Com a criação de um chatbot em forma de áudio, essas pessoas terão a possibilidade de tirar suas dúvidas e receber informações de forma mais acessível e inclusiva. A iniciativa busca, portanto, promover a igualdade de oportunidades e o acesso à informação para pessoas com deficiência visual.
Nesse caso, a iniciativa também promove a inclusão e acessibilidade para um público mais amplo, ampliando o alcance e a utilidade do serviço oferecido. A acessibilidade deve ser uma preocupação de todos, e a inclusão de opções de áudio pode tornar o chatbot mais acessível e eficiente para diferentes públicos.
Nesse repositório está o código da parte de cadastro do usuário. Nele temos duas tabelas: usuário e endereço, a segunda sendo cadastrada, apagada e atualizada a partir do CRUD do usuário. Foi feito deploy da API em um Azure WebApp pelo Azure Devops Pipeline.

## Benefício em relação ao negócio
- Acessibilidade Aprimorada  
- Igualdade de Oportunidades  
- Independência e Autonomia  
- Ampla Adoção  
- Economia de Tempo e Esforço  
- Ampliação da Base de Clientes  
- Responsabilidade Social e Imagem Corporativa  
- Conveniência para Todos    
  
Em resumo, o projeto "HearMeOut" não apenas atende a uma necessidade importante de acessibilidade para pessoas com deficiência visual, mas também oferece vantagens comerciais, sociais e de imagem corporativa para a Plusoft. Ao investir na acessibilidade e na inclusão, a empresa está alinhada com os valores contemporâneos de diversidade e igualdade, ao mesmo tempo em que amplia sua base de clientes e melhora a experiência do usuário para todos os públicos.

## O Pipeline
![10435234](https://github.com/trcosta97/devops-sprint5/assets/101136329/0a04ab43-30e7-417d-83eb-b3666409884a)

Vídeo do deploy: https://youtu.be/NSRXSD8HNc0


### Controle de Versão
O código-fonte da sua aplicação é armazenado e gerenciado em um repositório Git hospedado no Azure DevOps. Isso permite o controle de versão, colaboração e rastreamento de alterações.  

### Automação de Build  
O Azure DevOps inicia automaticamente o processo de compilação da aplicação com base nas configurações definidas na pipeline. Isso envolve a coleta do código-fonte do repositório, a resolução de dependências, a compilação e a geração de artefatos executáveis.  

### Testes
Após a compilação, os testes definidos na aplicação são executados para garantir que o código individual esteja funcionando corretamente. Os resultados dos testes são registrados.

### Empacotamento
Os artefatos gerados são preparados para implantação, como empacotar o aplicativo em um arquivo JAR.

### Publicação
A aplicação, agora empacotada em um JAR, é publicada em um Azure WebApp previamente criado e, como configurado na Pipeline, tem o trigger que atualiza a partir dos commits no repositório raiz.

### Métricas e Relatórios
A Azure gera relatórios e métricas sobre o desempenho da pipeline e do aplicativo, permitindo uma avaliação detalhada.

## JSON para a API:
### Cadastro de usuário:
URL: "/user/post"  
VERBO: POST  
```console
  {
  "name": "string",
  "cpf": "string",
  "email": "string",
  "password": "string",
  "address": {
    "number": "string",
    "street": "string",
    "city": "string",
    "cep": "string",
    "province": "AC",
    "complement": "string"
  },
  "gender": "MASCULINE"
}
```

### Atualização de usuário:
URL: "/user/update/{id}" sendo {id} o id do usuário pesquisado    
VERBO: PUT 
  ```
  {
  "email": "string",
  "password": "string",
  }
  ```
### Pesquisa de usuário:
URL: "/user/get/{id}" sendo {id} o id do usuário pesquisado    
VERBO: GET   

### Listagem de usuários:
URL: "/user/get"   
VERBO: GET  

### Exclusão lógica de usuário:
URL: "/user/delete/{id}" sendo {id} o id do usuário excluído  
VERBO: DELETE 
