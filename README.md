Baixe o projeto StateMachine. Para executar vá em StateMachine->StateMachine->src->main.
Na parta src temos todas as classes, sendo os personagens o Bruiser e o Healer.
Temos a interface State, a classe Abstract State e o Main
O resto dos script são estados do bruiser e do healer
No Main temos um aleatorizador de dano que simboliza as ações imprevisiveis do player.
O Healer: Heitor realiza magias de cura com: areaHeal, Healing, e Sacrifice. A maioria delas gastando mana para executar
Bruiser: Bruna realiza ataques gastando energia com o estado Attack.
Ambos possuem o estado Resting para recuperar seus recursos

Quando um agente troca de estado ele informa no log a mudança.

Deixamos valores arbitrários para:
⦁	Numero de ciclos
⦁	Intervalo entre interações
⦁	Dano do jogador
O foco do trabalho foi na execução de maquinas de estado e pode ser útil alterar estes valores para melhor visualizar.
