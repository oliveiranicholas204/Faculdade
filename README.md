# Faculdade
Aluno: Nicholas de Camargo Oliveira
2ºano Ciência da Computação

Trabalho de Física: Calculador de Frenagem e Atrito

O programa trás como contexto, um caso onde um carro está indo em rota de colisão a um muro, e o motorista deve decidir se deve frear ou desviar.<br>
 Apartir desse cenário, o programa calcula qual decisão impede a colisão ou se ela não pode ser evitada, e caso possa ser, qual a melhor escolha. O cálculo é feito utilizando seis valores que serão fornecidos pelo usuário, sendo eles: a distância entre o carro e o muro em metros, a massa do carro em quilos, a velocidade inicial do veículo em metros por segundo, os coeficientes de atrito estático e cinético, e a largura do desvio disponível em metros.
Após a realização dos cálculos, serão mostrados: O atrito máximo que disponível para ser utilizado, o atrito mínimo necessário para que o carro consiga frear, a velocidade de impacto caso a colisão aconteça, a força necessária para fazer a curva e a decisão final.
A decisão se baseia no seguinte: se a força de atrito necessária para parar for suficiente e a força para desviar não, então frear é a melhor opção,  e vice - versa. Porém se as duas forem possíveis, mesmo que seja necessário menos força para desviar do que para frear, frear ainda será a melhor opção devido ao ser levado em conta que pode haver algum obstáculo na hora do desvio. Caso nenhuma seja possível a colisão é inevitável.
A adição do input largura do desvio, assim como certas modificações em relação a questão original do livro foram necessárias, pois foi descoberto que seu cálculo original sempre beneficiava a opção frear e se apenas pequenas mudanças fossem feitas, a opção desviar passava a ser beneficiada, sendo necessária a adição deste input, algumas mudanças no cálculo original e a adição da opção das duas sendo possiveis, para tentar balancear os resultados da decisão.
