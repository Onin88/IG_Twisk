#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/sem.h>
#include <sys/wait.h>

#define NUM_CLIENTS 5
#define MAX_TOKENS 3

// Structure pour la mémoire partagée
struct shared_data {
    int tokens;
};

// Fonction pour effectuer les opérations de sémaphore
void semaphore_wait(int sem_id) {
    struct sembuf sb = {0, -1, 0};
    semop(sem_id, &sb, 1);
}

void semaphore_signal(int sem_id) {
    struct sembuf sb = {0, 1, 0};
    semop(sem_id, &sb, 1);
}

void simulate_client(int client_id, struct shared_data *data, int sem_id) {
    printf("Client %d : attente d'un jeton.\n", client_id);
    
    semaphore_wait(sem_id); // Attente d'un jeton

    // Section critique : accès à la ressource
    data->tokens--;
    printf("Client %d : jeton acquis, reste %d jetons.\n", client_id, data->tokens);
    
    // Simuler l'utilisation de la ressource
    sleep(rand() % 3 + 1); // Attente entre 1 et 3 secondes

    // Libération du jeton
    data->tokens++;
    printf("Client %d : tâche terminée, jeton rendu, reste %d jetons.\n", client_id, data->tokens);
    
    semaphore_signal(sem_id); // Signal pour libérer un jeton
}

int main() {
    int shm_id, sem_id;
    struct shared_data *data;

    // Création de la mémoire partagée
    shm_id = shmget(IPC_PRIVATE, sizeof(struct shared_data), IPC_CREAT | 0666);
    data = (struct shared_data *)shmat(shm_id, NULL, 0);
    data->tokens = MAX_TOKENS; // Initialisation des jetons

    // Création du sémaphore
    sem_id = semget(IPC_PRIVATE, 1, IPC_CREAT | 0666);
    semctl(sem_id, 0, SETVAL, 1); // Initialiser le sémaphore à 1

    pid_t pid;
    for (int i = 0; i < NUM_CLIENTS; i++) {
        pid = fork(); // Création du processus client

        if (pid < 0) {
            perror("Erreur lors de la création du processus");
            exit(1);
        } else if (pid == 0) {
            // Processus enfant
            simulate_client(i + 1, data, sem_id);
            exit(0); // Terminer le processus enfant
        }
    }

    // Attendre la fin de tous les processus enfants
    for (int i = 0; i < NUM_CLIENTS; i++) {
        wait(NULL);
    }

    // Nettoyage
    shmdt(data);
    shmctl(shm_id, IPC_RMID, NULL);
    semctl(sem_id, 0, IPC_RMID);

    printf("Tous les clients ont terminé leurs tâches.\n");
    return 0;
}