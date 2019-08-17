package file

File arqFinal = new File("D:/JavaD/_scripts/Y800/arq_gerado_com_Y800.txt")

def contador = 0
arqFinal << ("|Y800|")
new File("D:/JavaD/_scripts/Y800/arq_y800.rtf").eachLine { line ->
  if (contador > 0) arqFinal << '\n'
  arqFinal << line
  contador++
}
arqFinal << ("|Y800FIM|\n")

System.console().readLine '\nProcesso finalizado com sucesso!! Click ENTER to quit'