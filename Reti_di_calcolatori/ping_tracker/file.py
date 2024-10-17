from pythonping import ping
import statistics

def measure_rtt(host, count=4):
    response_list = ping(host, count=count, verbose=True)
    # Il verbose=True stamperà i dettagli di ogni pacchetto inviato

    # Estrae i tempi di risposta individuali
    rtts = [response.time_elapsed_ms for response in response_list if response.success]

    # Calcola la media e la deviazione standard dei tempi di risposta
    if rtts:
        avg_rtt = statistics.mean(rtts)
        std_dev_rtt = statistics.stdev(rtts) if len(rtts) > 1 else 0 # se la lista è empty la deviazione stanard è zero

        print(f"\n\nAverage RTT to {host}: {avg_rtt:.2f} ms")
        print(f"Standard Deviation of RTT to {host}: {std_dev_rtt:.2f} ms")
    else:
        print("No successful responses received.")

# Utilizzo della funzione
measure_rtt('8.8.8.8', count=10)
