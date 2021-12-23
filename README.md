# BXA_TempSeleniumLista

Neste repositório existem alguns exercícios resolvidos sobre automação de testes utilizando **Selenium**.
Os exercícios a seguir eram para ser resolvidos no site: [Sauce Demo](https://www.saucedemo.com/)

### Exercícios ###

1. Faça um algoritmo que logue no sistema usando o usuário standard_user e valide se logou com sucesso.
2. Estando logado no sistema, adicione um item no carrinho e valide se o mesmo item foi adicionado ao carrinho.
3. Estando logado no sistema, filtre os itens do menor preço para o maior e valide se o filtro foi aplicado corretamente.
4. Estando logado no sistema, adicione o terceiro item no carrinho, navegue até o carrinho valide se o item está lá e após isso, remova-o do carrinho e valide se foi feita a remoção.
5. Estando logado no sistema, adicione todos os itens no carrinho e valide a adição.
6. Estando logado no sistema, adicione o primeiro item ao carrinho e o remova do carrinho sem ir para a página do carrinho e valide se a remoção foi efetuada.
7. Estando logado no sistema, valide se o produto Sauce Labs Backpack está aparecendo na tela.
8. Faça um algoritmo que tenta logar no sistema usando o usuário locked_out_user e valide a mensagem de erro.
9. Estando logado no sistema, adicione o primeiro item no carrinho, navegue até o carrinho, clique em checkout, insira dados nos campos e finalize a compra, validando em cada uma das telas se os dados que você julgar como mais importantes estão corretos.

# Sobre a estrutura do projeto

O possui duas pastas principais:

- src/main/java
- src/test/java

### src/main/java

Neste diretório encontram-se as classes criadas para dar suporte aos testes, como as classes **page** e as classes do pacote **framework**.
Cada classe **page** herda de uma classe **object** o mapeamento de um elemento da página utilizando o `By` do Selenium. Há também um atributo nas classes **pages** do tipo `Exeute`. `Execute` é um classe presente no pacote **framework** que provê e abstrai funcionalidades para manipular a biblioteca o `WebDriver`, tornando o código nas classes **pages** mais legíveis.
No pacote **framework** há também a classe `DriverFactory` (provendo um ponto de acesso único ao `WebDriver` do **Selenium**) e o `DriverProperties`. A última ofere algumas confifurações para as execuções dos testes. Essas configurações podem ser alteradas nos seguintes atributos:

```java
	public static boolean debugMode = true;
	public static boolean killDriver = true;
	public static DriverBrowsers browser = DriverBrowsers.CHROME;
```

- `debugMode`: `true` para renderizar a janela do browser e `false` caso contrário;
- `killDriver`: `true` para finalizar a instância do `WebDriver` no final de cada teste e `false` caso contrário;
- `browser`: define qual browser será utilizado nos testes de acordo com os disponíveis no `enum DriverBrowsers`.

Ainda no pacote **framework**, existem as classes `Screenshot` e `Counter` responsáveis por, respectivamente, tirar uma foto do browser como evidência e cronometrar a duração dos testes.

### src/test/java

Neste diretório encontram-se as classes de testes. Todas elas herdam alguns comportamentos da classe `BaseTest`. Nela está contida as implementações para salvar as evidências dos testes e para cronometrar a duração dos testes.


