import numpy as np
import time


def bubble_sort(lista):
    # Coloca o tamanho da lista na variavel
    n = len(lista)
    # Se o array for menor ou igual a 1 retorna o array
    if len(lista) <= 1:
        return lista
    # Percorre a lista
    for i in range(n):
        # Percorre a lista de 0 até n-1
        for j in range(0, n - 1):
            # Compara elementos
            if lista[j] > lista[j + 1]:
                # Troca elementos
                lista[j], lista[j + 1] = lista[j + 1], lista[j]


def quick_sort(lista):
    # Se o array for menor ou igual a 1 retorna o array
    if len(lista) <= 1:
        return lista
    else:
        # Coloca o primeiro valor do array como pivo
        pivo = lista[0]
        # Cria um array com os valores menores ou igual ao pivo
        less = [x for x in lista[1:] if x <= pivo]
        # Cria um array com os valores maiores ou igual ao pivo
        greater = [x for x in lista[1:] if x > pivo]
        # Chama a função novamente com o array modificado, um pouco mais ordenado
        return quick_sort(less) + [pivo] + quick_sort(greater)


def main():
    # Guarda o tempo inicial
    inicio = time.perf_counter()

    # Gera um array de x valores aleatórios entre x e y
    rand_array = np.random.randint(0, 10000, size=100000)

    # Chama a função de ordenação
    bubble_sort(rand_array)
    # rand_array = quick_sort(rand_array)
    # print(rand_array)

    # Guarda o tempo final
    fim = time.perf_counter()
    # Calcula o tempo de execução
    tempo_execucao = fim - inicio
    print("Tempo de execução: ", tempo_execucao, "segundos")


if __name__ == '__main__':
    main()
